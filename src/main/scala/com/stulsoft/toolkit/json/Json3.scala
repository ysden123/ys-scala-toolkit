/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.toolkit.json

import upickle.default.*
import com.typesafe.scalalogging.StrictLogging

/**
 * Serializing an object to JSON.
 *
 * @see [[https://docs.scala-lang.org/toolkit/json-serialize.html]]
 */
object Json3 extends StrictLogging:
  /**
   * Map to JSON
   */
  private def test1(): Unit =
    logger.info("==>test1")
    val map: Map[String, Int] =
      Map("Toolkitty" -> 3, "Scaniel" -> 5)
    val jsonString: String = upickle.default.write(map)
    println(jsonString)

  private case class PetOwner(name: String, pets: List[String]) derives ReadWriter

  /**
   * Serializing a custom object to JSON
   */
  private def test2():Unit=
    logger.info("==>test2")
    val petOwner = PetOwner("Peter", List("Toolkitty", "Scaniel"))
    val json: String = write(petOwner)
    println(json)

  def main(args: Array[String]): Unit = {
    logger.info("==>main")
    test1()
    test2()
  }
