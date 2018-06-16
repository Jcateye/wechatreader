package com.jxlg.haoqi.wechatreader.Utils;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;
import java.util.UUID;

public class PdfResolver {

    @Test
    public void getPdfOfTxt() {
        try {
            // 是否排序
            boolean sort = false;
            // 开始提取页数
            int startPage = 1;
            // 结束提取页数
            int endPage = Integer.MAX_VALUE;
            String encoding = "UTF-8";
            Writer output = null;
            String content = null;
            PrintWriter writer = null;
            //pdf文本路径
            String path = "D:\\Download\\ebook\\[www.52yzzy.com 吾爱优质资源网] 33_Docker相关\\循序渐进学Docker.pdf";
            //输出txt文本路径
            String target="E:\\wechatreaderBook\\循序渐进学Docker.txt";
//            PDDocument document = PDDocument.load(new File(path));
//            PDFTextStripper pts = new PDFTextStripper();

            // 文件输入流，写入文件到textFile @2 “E:\\data\\Outputtxt\\”是text文档输出目录（自己可以设置）
            output = new OutputStreamWriter(new FileOutputStream(
                    target), encoding);
            RandomAccessRead accessRead = new RandomAccessFile(new File(
                    path), "rw");
            PDFParser parser = new PDFParser(accessRead); // 创建PDF解析器
            parser.parse(); // 执行PDF解析过程
            PDDocument pdfdocument = parser.getPDDocument(); // 获取解析器的PDF文档对象
            PDFTextStripper pdfstripper = new PDFTextStripper(); // 生成PDF文档内容剥离器

            endPage = pdfdocument.getNumberOfPages();
            System.out.println("Total Page: " + endPage);
            pdfstripper.setStartPage(startPage);
            pdfstripper.setEndPage(endPage);
            pdfstripper.writeText(pdfdocument, output);

            if (output != null) {
                // 关闭输出流
                output.close();
            }
            if (pdfdocument != null) {
                // 关闭PDF Document
                pdfdocument.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     *            pdf文件的全路径
     * @return
     * @throws Exception
     *
     *             SEVERE: Could not load font file: C:\Windows\FONTS\mstmc.ttf
     *             可能报这样的警告信息。倒是内容能够正确读到
     */
    @Test
    public void getTextFromPDF() throws Exception {
        String pdfFilePath = "D:\\Download\\ebook\\[www.52yzzy.com 吾爱优质资源网] 2_Spring相关\\徐勋健.pdf";
        RandomAccessRead accessRead = new RandomAccessFile(new File(
                pdfFilePath), "rw");
        PDFParser parser = new PDFParser(accessRead); // 创建PDF解析器
        parser.parse(); // 执行PDF解析过程
        PDDocument pdfdocument = parser.getPDDocument(); // 获取解析器的PDF文档对象
        PDFTextStripper pdfstripper = new PDFTextStripper(); // 生成PDF文档内容剥离器
        String contenttxt = pdfstripper.getText(pdfdocument); // 利用剥离器获取文档
        System.out.println(contenttxt);
        accessRead.close();
        pdfdocument.close();
        System.out.println(contenttxt);
        String target="E:\\wechatreaderBook\\徐勋健.txt";
        PrintWriter writer = new PrintWriter(new FileOutputStream(target));

        writer.write(contenttxt);// 写入文件内容
        writer.flush();
        writer.close();

    }

    @Test
    public void testPdf() {
        String path = "D:\\Download\\ebook\\[www.52yzzy.com 吾爱优质资源网] 2_Spring相关\\徐勋健.pdf";
        File file = new File(path);
        InputStream is = null;
        PDDocument document = null;
        try {
            if (path.endsWith(".pdf")) {
                document = PDDocument.load(file);
                int pageSize = document.getNumberOfPages();
                // 一页一页读取
                for (int i = 0; i < pageSize; i++) {
                    // 文本内容
                    PDFTextStripper stripper = new PDFTextStripper();
                    // 设置按顺序输出
                    stripper.setSortByPosition(true);
                    stripper.setStartPage(i + 1);
                    stripper.setEndPage(i + 1);
                    String text = stripper.getText(document);
                    System.out.println(text.trim());
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-");

                    // 图片内容
                    PDPage page = document.getPage(i);
                    PDResources resources = page.getResources();
                    Iterable<COSName> cosNames = resources.getXObjectNames();
                    if (cosNames != null) {
                        Iterator<COSName> cosNamesIter = cosNames.iterator();
                        while (cosNamesIter.hasNext()) {
                            COSName cosName = cosNamesIter.next();
                            if (resources.isImageXObject(cosName)) {
                                PDImageXObject Ipdmage = (PDImageXObject) resources.getXObject(cosName);
                                BufferedImage image = Ipdmage.getImage();
                                FileOutputStream out = new FileOutputStream("E:\\wechatreaderBook\\" + UUID.randomUUID() + ".png");
                                try {
                                    ImageIO.write(image, "png", out);
                                } catch (IOException e) {
                                } finally {
                                    try {
                                        out.close();
                                    } catch (IOException e) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (InvalidPasswordException e) {
        } catch (IOException e) {
        } finally {
            try {
                if (document != null) {
                    document.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
            }
        }
    }
    @Test
    public void fileTest() {

        File file = new File("E:\\wechatreaderBook");
        String[] list = file.list();
        for(String str : list) {
            System.out.println(str);
        }


    }

    @Test
    public void ioTest() throws IOException {
        FileInputStream fileInputStream = null;

        fileInputStream=   new FileInputStream(new File("E:\\wechatreaderBook\\二十年目睹之怪现状.txt"));
        InputStreamReader ir = new InputStreamReader(fileInputStream, "GB2312");
        char[] chars = new char[512];
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i<1 &&  ir.read(chars) != -1; i++) {
            sb.append(chars);
        }
        System.out.println(sb.toString());

    }

}
