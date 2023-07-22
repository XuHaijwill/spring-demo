<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:java="http://xml.apache.org/xslt/java"
                exclude-result-prefixes="java">

    <xsl:template match="/">		<!-- match='/'匹配整个文档或者元素根节点 -->
        <data>
            <xsl:variable name="name" select="Data/Base/Name"></xsl:variable>				<!-- 声明变量 -->
            <xsl:comment>内容开始</xsl:comment>												<!-- 增加注释 -->
            <xsl:copy-of select="Data/Base"></xsl:copy-of>									<!-- 节点拷贝 -->
            <height>value-of 获取值：<xsl:value-of select="Data/Base/Height"></xsl:value-of></height>	<!-- 提取某个选定节点的内容 -->
            <attribute><xsl:attribute name="增加属性">123</xsl:attribute></attribute>			<!-- 向元素添加属性 -->
            <xsl:apply-templates select="/Data/Input"></xsl:apply-templates>				<!-- 调用模板 -->
        </data>
    </xsl:template>
    <xsl:template match="/Data/Input">														<!-- 有上下文模板 -->
        <xsl:for-each select="School">														<!-- 循环选取指定的节点 -->
            <xsl:sort select="Profession/Class/Ranking"></xsl:sort>							<!-- 按指定节点值进行排序 -->
            <date><xsl:value-of select="Profession/Class/Ranking"></xsl:value-of></date>
            <outcome>
                <xsl:choose>
                    <xsl:when test="Profession/Class/Ranking > 50">良好</xsl:when>			<!-- xsl不识别小于号 -->
                    <xsl:otherwise>优秀</xsl:otherwise>
                </xsl:choose>
            </outcome>
            <xsl:for-each select="Profession/Class/Course/CourseName">
                <CourseName><xsl:value-of select="text()"></xsl:value-of></CourseName>		<!-- 选取当前节点的内容 -->
            </xsl:for-each>
        </xsl:for-each>
    </xsl:template>
    <xsl:template name="private">															<!-- 无上下文模板 -->
        <content>call模板内容为：<xsl:value-of select="Data/Input/School/Profession/Class/Ranking"></xsl:value-of></content>
    </xsl:template>
</xsl:stylesheet>