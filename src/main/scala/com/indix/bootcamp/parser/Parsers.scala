package com.indix.bootcamp.parser

import com.indix.bootcamp.models.{Product, Price, Result}
import org.jsoup.nodes.Document

class FlipkartParser extends Parser {
  override def parseProduct(document: Document, pageUrl: String): Product = {
    val title = document.select("h1[itemprop=name]").text()
    val description = document.select("#specifications").text()
    Product(title, description, pageUrl)
  }

  // TODO: Fix the price Extraction
  override def parsePrice(document: Document): Price = {
    val listPrice = document.select(".old-price").text().split(" ")(1).toDouble
    val salePrice = document.select("itemprop[name=price]").attr("content").toDouble
    println(salePrice)
    Price(listPrice, salePrice)

  }
}

class JabongParser extends Parser {
  override def parseProduct(document: Document, pageUrl: String): Product = {
    val title = document.select("span[itemprop=name").text()
    val description = document.select("#productInfo p").text()
    //println(description)
    Product(title,description,pageUrl)

  }

  override def parsePrice(document: Document): Price = {
    val salePrice = document.select("span[itemprop=price]").text().toDouble
    val listPrice = document.select(".striked-price fs14 c222 d-inline mt5").text()
    if(listPrice.isEmpty == true) Price(salePrice,salePrice)
    else Price(listPrice.toDouble,salePrice)
  }
}
