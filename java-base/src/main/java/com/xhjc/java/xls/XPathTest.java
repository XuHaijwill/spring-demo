package com.xhjc.java.xls;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

/**
 * 一文弄懂XML文件解析利器XPath
 * https://blog.csdn.net/gongm24/article/details/105599786
 */
public class XPathTest {

    public static void main(String[] args) throws Exception {
        // 第一步：使用 DOM 解析器加载 XML 文件
        Document doc = load("files/inventory.xml");
        // 第二步：构建XPath 对象
        // 创建 XPathFactory
        XPathFactory factory = XPathFactory.newInstance();
        // 创建 XPath 对象
        XPath xpath = factory.newXPath();
        // 第三步：构建 XPathExpression 表达式并执行
        printTitleByAuthor(xpath, doc, "Neal Stephenson");
        printTitleAfterYear(xpath, doc, 1997);
        printDescrAfterYear(xpath, doc, 1997);
    }

    private static Document load(String filename) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        // 开启验证
        documentBuilderFactory.setValidating(true);
        documentBuilderFactory.setNamespaceAware(false);
        documentBuilderFactory.setIgnoringComments(true);
        documentBuilderFactory.setIgnoringElementContentWhitespace(false);
        documentBuilderFactory.setCoalescing(false);
        documentBuilderFactory.setExpandEntityReferences(true);
        // 创建DocumentBuilder
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        // 设置异常处理
        builder.setErrorHandler(new ErrorHandler() {
            public void warning(SAXParseException exception) throws SAXException {
                System.out.println("WARN:" + exception.getMessage());
            }
            public void error(SAXParseException exception) throws SAXException {
                System.out.println("error:" + exception.getMessage());
            }
            public void fatalError(SAXParseException exception) throws SAXException {
                System.out.println("fatalError:" + exception.getMessage());
            }
        });
        // 加载文档
        return builder.parse(ClassLoader.getSystemResourceAsStream(filename));
    }

    /**
     * 打印指定作者的图书的标题
     * @param author 作者名
     */
    private static void printTitleByAuthor(XPath xpath, Document doc, String author) throws Exception {
        System.out.println(String.format("打印作者%s的图书的标题:", author));
        String expression = String.format("//book[author='%s']/title/text()", author);
        // 编译 XPath 表达式
        XPathExpression expr = xpath.compile(expression);
        // 通过 XPath 在 DOM 文档中进行查询，
        // 第一个参数指定 XPath 表达式进行查询的目标上下文节点；
        // 第二个参数指定 XPath 表达式的返回类型。
        NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }
    }

    /**
     * 打印指定年份之后的图书的标题
     * @param year 年份
     */
    private static void printTitleAfterYear(XPath xpath, Document doc, Integer year) throws Exception {
        System.out.println(String.format("查询 %d 年之后的图书的标题:", year));
        // 编译 XPath 表达式
        String expression = String.format("//book[@year>%d]/title/text()", year);
        XPathExpression expr = xpath.compile(expression);
        // 通过 XPath 在 DOM 文档中进行查询，
        NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }
    }

    /**
     * 打印指定年份之后的图书的详细信息
     * @param year 年份
     */
    private static void printDescrAfterYear(XPath xpath, Document doc, Integer year) throws Exception {
        System.out.println(String.format("查询 %d 年之后的图书的属性和标题:", year));
        // 编译 XPath 表达式
        String expression = String.format("//book[@year>%d]/@*|//book[@year>%d]/title/text()", year, year);
        XPathExpression expr = xpath.compile(expression);
        // 通过 XPath 在 DOM 文档中进行查询，
        NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }
    }


}
