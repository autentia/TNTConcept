<?xml version="1.0"?>
<!--

    TNTConcept Easy Enterprise Management by Autentia Real Bussiness Solution S.L.
    Copyright (C) 2007 Autentia Real Bussiness Solution S.L.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

-->

<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
>

<xsl:output method="html" indent="no" encoding="ISO-8859-1"/>
<xsl:param name="context"/>
<xsl:param name="renderId"/>
<xsl:param name="token"/>
<xsl:param name="imgpath" select="'bii/table'"/>

<xsl:template match="/mdxtable">
    <!-- comentamos la llamada para evitar que se muestre en pantalla
    las condiciones de la claúsula WHERE -->
  <xsl:apply-templates select="slicer/member"/>
</xsl:template>

<xsl:template match="member[@href]">
  <xsl:text> [</xsl:text>
  <span class="slicer-{@style}">
    <a href="{@href}">
      <xsl:value-of select="@level"/>
      <xsl:text>=</xsl:text>
      <xsl:value-of select="@caption"/>
    </a>
  </span>
  <xsl:text>] </xsl:text>
</xsl:template>

<xsl:template match="member">
  <xsl:text> [</xsl:text>
  <span class="slicer-{@style}">
    <xsl:value-of select="@level"/>
    <xsl:text>=</xsl:text>
    <xsl:value-of select="@caption"/>
  </span>
  <xsl:apply-templates select="property"/>
  <xsl:text>] </xsl:text>
</xsl:template>

<xsl:template match="property">
  <xsl:text>, </xsl:text>
  <xsl:value-of select="@name"/>
  <xsl:text>=</xsl:text>
  <xsl:value-of select="@value"/>
</xsl:template>

</xsl:stylesheet>
