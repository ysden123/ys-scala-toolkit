/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.toolkit.json

import upickle.default.*
import com.typesafe.scalalogging.StrictLogging

/**
 * Parsing and deserialization
 *
 * @see [[https://docs.scala-lang.org/toolkit/json-deserialize.html#parsing-vs-deserialization]]
 */
object Json2 extends StrictLogging:
  /**
   * Deserializing JSON to a Map
   */
  private def test1():Unit=
    logger.info("==>test1")
    val json = """{"primes": [2, 3, 5], "evens": [2, 4, 6]} """
    val map: Map[String, List[Int]] =
      upickle.default.read[Map[String, List[Int]]](json)

    println(map)
    println(map("primes"))

  private case class PetOwner(name: String, pets: List[String]) derives ReadWriter

  /**
   * Deserializing JSON to a custom data type
   */
  private def test2():Unit=
    logger.info("==>test2")
    val json = """{"name": "Peter", "pets": ["Toolkitty", "Scaniel"]}"""
    val petOwner: PetOwner = read[PetOwner](json)

    val firstPet = petOwner.pets.head
    println(s"${petOwner.name} has a pet called $firstPet")

  def main(args: Array[String]): Unit = {
    logger.info("==>main")
    test1()
    test2()
  }
