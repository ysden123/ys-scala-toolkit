/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.toolkit.json

import com.typesafe.scalalogging.StrictLogging

object Json1 extends StrictLogging:
  /**
   * Accessing values inside JSON
   *
   * @see [[https://docs.scala-lang.org/toolkit/json-parse.html#accessing-values-inside-json]]
   */
  private def test1(): Unit =
    logger.info("==>test1")
    val jsonString = """{"name": "Peter", "age": 13, "pets": ["Toolkitty", "Scaniel"]}"""
    val json: ujson.Value = ujson.read(jsonString)
    println(json("name").str)
    println(json)

    // To access the elements by index in a JSON array
    val pets: ujson.Value = json("pets")

    val firstPet: String = pets(0).str
    val secondPet: String = pets(1).str

    println(s"The pets are $firstPet and $secondPet")

  /**
   * HOW TO MODIFY JSON
   */
  private def test2():Unit=
    logger.info("==>test2")
    // Parse the JSON string
    val json: ujson.Value = ujson.read("""{"name":"John","pets":["Toolkitty","Scaniel"]}""")

    // Update it
    json("name") = "Peter"
    json("nickname") = "Pete"
    json("pets").arr.remove(1)

    // Write it back to a String
    val result: String = ujson.write(json)
    println(result)

  def main(args: Array[String]): Unit = {
    logger.info("==>main")

    test1()
    test2()
  }
