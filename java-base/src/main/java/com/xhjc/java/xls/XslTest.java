package com.xhjc.java.xls;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.transform.XSLTransformException;
import org.jdom2.transform.XSLTransformer;
import org.jdom2.xpath.XPath;

import java.io.*;

public class XslTest {
    public static void main(String[] args) throws IOException {
        //设置xml输出格式
        Format mFormat = Format.getRawFormat().setIndent("   ");
        mFormat.setEncoding("UTF-8");
        /*---------------------------XML---------------------------*/
        //读入xml文件
        InputStream is = ClassLoader.getSystemResourceAsStream("files/Demo1.xml");
        //通过SAX生成xml树
        SAXBuilder xmlBuilder = new SAXBuilder();
        xmlBuilder.setIgnoringBoundaryWhitespace(true);
        Document sData = null;
        try
        {
            sData =  xmlBuilder.build(is);
        }
        catch (JDOMException | IOException e1)
        {
            System.out.println("创建Xml树失败");
            e1.printStackTrace();
        }
        System.out.println(new XMLOutputter(mFormat).outputString(sData));

        /*---------------------------XSL---------------------------*/
        //读入xsl文件
        is = ClassLoader.getSystemResourceAsStream("files/Demo1.xsl");
        XSLTransformer xslTransformer = null;
        try
        {
            //建立xsl转换器
            xslTransformer = new XSLTransformer(is);
        }
        catch (XSLTransformException e)
        {
            System.out.println("建立Xsl转换器出错");
            e.printStackTrace();
        }
        Document xmlOutcome = null;
        try
        {
            //进行xsl转换
            xmlOutcome = xslTransformer.transform(sData);
        }
        catch (XSLTransformException e)
        {
            System.out.println("Xsl转换出错");
            e.printStackTrace();
        }
        String xslOutString = new XMLOutputter(mFormat).outputString(xmlOutcome);
        //输出转换后的结果
        System.out.println(xslOutString);
        OutputStream os = new FileOutputStream("D:/output.xml");
        os.write(xslOutString.getBytes());

        /*---------------------------XPATH---------------------------*/
        //XPath选择特定节点
        XPath path = null;
        Element ele = null;
        try
        {
            path = XPath.newInstance("Data/Input/School/Profession[Class/Ranking = '60']");
        }
        catch (JDOMException e)
        {
            System.out.println("XPath路径出错");
            e.printStackTrace();
        }
        try
        {
            ele = (Element) path.selectSingleNode(sData);
        }
        catch (JDOMException e)
        {
            System.out.println("XPath选择节点出错");
            e.printStackTrace();
        }
        xslOutString = new XMLOutputter(mFormat).outputString(ele);
        System.out.println(xslOutString);
    }
}
