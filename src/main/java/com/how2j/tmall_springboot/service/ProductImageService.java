package com.how2j.tmall_springboot.service;

import com.how2j.tmall_springboot.Enum.TypeEnum;
import com.how2j.tmall_springboot.constant.FolderConstants;
import com.how2j.tmall_springboot.dao.ProductImageDAO;
import com.how2j.tmall_springboot.pojo.Product;
import com.how2j.tmall_springboot.pojo.ProductImage;
import com.how2j.tmall_springboot.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ProductImageService {
    @Autowired
    private ProductImageDAO productImageDAO;
    @Autowired
    private ProductService productService;

    public Object add(int pid, String type, MultipartFile multipartFile, HttpServletRequest request) {

        ProductImage image = new ProductImage();
        image.setProduct(productService.get(pid));
        image.setType(type);
        productImageDAO.save(image);

        File imageFolder;
        if (type.equals(TypeEnum.type_single.getType())) {
            imageFolder = new File(request.getServletContext().getRealPath(FolderConstants.SINGLE_FOLDER));
        } else {
            imageFolder = new File(request.getServletContext().getRealPath(FolderConstants.DETAIL_FOLDER));
        }
        File file = new File(imageFolder, image.getId() + ".jpg");
        String fileName = file.getName();
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            multipartFile.transferTo(file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (type.equals(TypeEnum.type_single.getType())) {
            String imageFolder_small = request.getServletContext().getRealPath(FolderConstants.IMAGE_FOLDER_SMALL);
            String imageFolder_middle = request.getServletContext().getRealPath(FolderConstants.IMAGE_FOLDER_MIDDLE);
            File f_small = new File(imageFolder_small, fileName);
            File f_middle = new File(imageFolder_middle, fileName);
            f_small.getParentFile().mkdirs();
            f_middle.getParentFile().mkdirs();
            ImageUtil.resizeImage(file, 56, 56, f_small);
            ImageUtil.resizeImage(file, 217, 190, f_small);
        }
        return image;
    }

    public ProductImage get(int id) {
        return productImageDAO.getOne(id);
    }

    public String delete(int id, HttpServletRequest request) {


        ProductImage image = this.get(id);
        productImageDAO.deleteById(id);
        File imageFolder;
        if (image.getType().equals(TypeEnum.type_single.getType())) {
            imageFolder = new File(request.getServletContext().getRealPath(FolderConstants.SINGLE_FOLDER));
        } else {
            imageFolder = new File(request.getServletContext().getRealPath(FolderConstants.DETAIL_FOLDER));
        }

        File file = new File(imageFolder, id + ".jpg");
        String fileName = file.getName();
        if (file.exists()) {
            file.delete();
        }
        if (image.getType().equals(TypeEnum.type_single.getType())) {
            String imageFolder_small = request.getServletContext().getRealPath(FolderConstants.IMAGE_FOLDER_SMALL);
            String imageFolder_middle = request.getServletContext().getRealPath(FolderConstants.IMAGE_FOLDER_MIDDLE);
            File f_small = new File(imageFolder_small, fileName);
            File f_middle = new File(imageFolder_middle, fileName);
            f_small.delete();
            f_middle.delete();
        }
        return null;
    }

    public List<ProductImage> listSingleProductImages(Product product) {
        return productImageDAO.findByProductAndTypeOrderByIdDesc(product, TypeEnum.type_single.getType());
    }

    public List<ProductImage> listDetailProductImages(Product product) {
        return productImageDAO.findByProductAndTypeOrderByIdDesc(product, TypeEnum.type_detail.getType());
    }

    private void setFirstProductImage(Product product) {
        List<ProductImage> singleImageList = listSingleProductImages(product);
        if (!singleImageList.isEmpty()) {
            product.setFirstProductImage(singleImageList.get(0));
        } else {
            product.setFirstProductImage(new ProductImage());
        }
    }

    public void setFirstProductImages(List<Product> products) {
        products.forEach(this::setFirstProductImage);
    }

}
