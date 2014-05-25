package com.indix.bootcamp.parser

import org.scalatest.{Matchers, FunSuite}
import com.indix.bootcamp.utils.TestUtils

class JabongParserTest extends FunSuite with Matchers with TestUtils {

  test("should parse product page") {
    val document = readDocument("/jabong/jabong_1.html")
    val parser = new JabongParser
    val parsedProduct = parser.parseProduct(document, "http://www.jabong.com/Us_Polo_Assn-Red-Polos-248683.html")
    parsedProduct.name should be("Red Polos")
    parsedProduct.description should include("Refreshing and trendy, this red coloured polo T-shirt for boys from the house of U.S. Polo Assn. will give your little boy a perfect casual look. Made from 100% cotton, this T-shirt is high on comfort. It features a brand logo on the front to accentuate his look. Let him team it with navy-blue coloured 3/4ths and a pair of crocs to look adorable")
  }

  test("should parse prices from product page") {
    val document = readDocument("/jabong/jabong_1.html")
    val parser = new JabongParser
    val parsedPrice = parser.parsePrice(document)
    println(parsedPrice.listPrice)
    parsedPrice.listPrice should be(899.0)
    parsedPrice.salePrice should be(899.0)
  }
}


