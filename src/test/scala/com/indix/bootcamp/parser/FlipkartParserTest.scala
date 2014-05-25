package com.indix.bootcamp.parser

import org.scalatest.{Matchers, FunSuite}
import com.indix.bootcamp.utils.TestUtils

class FlipkartParserTest extends FunSuite with Matchers with TestUtils {

  test("should parse product page") {
    val document = readDocument("/flipkart/flipkart_1.html")
    val parser = new FlipkartParser
    val parsedProduct = parser.parseProduct(document, "http://www.flipkart.com/fastrack-explorer-analog-watch-men/p/itmdmmzyz26qjrh9?pid=WATDMMZVQVUJ3E6F&srno=b_1&ref=92832318-0578-4e09-835d-79e2df08e6c9")
    parsedProduct.name should be("Fastrack Explorer Analog Watch - For Men")
    parsedProduct.description should include("Specifications of Fastrack Explorer Analog Watch - For Men (Dark Blue) General Type Analog Series Explorer Ideal For Men Occasion College Style Code 9463AL07 Body Features Strap Material Canvas Strap Strap Color Dark Blue Dial Color Blue Dial Shape Round Other Body Features Contrast Color Leather Loops, Strap with Soft Leather Lining Warranty 6 Months Domestic Warranty")
  }

  test("should parse prices from product page") {
    val document = readDocument("/flipkart/flipkart_1.html")
    val parser = new FlipkartParser
    val parsedPrice = parser.parsePrice(document)
    println(parsedPrice.listPrice)
    //parsedPrice.listPrice should be(0.0)
    parsedPrice.salePrice should be(1995.0)
  }
}


