/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.toolkit.json

import upickle.default.*
import com.typesafe.scalalogging.StrictLogging

/**
 * Read and write JSON files
 *
 * @see [[https://docs.scala-lang.org/toolkit/json-files.html]]
 */
object Json4 extends StrictLogging:
  private case class PetOwner(name: String, pets: List[String]) derives ReadWriter
  /**
   * Read and write raw JSON
   */
  private def test1():Unit=
    logger.info("==>test1")
    // read a JSON file
    val json = ujson.read(os.read(os.pwd / "data" / "raw.json"))
    println(json)

    // modify the JSON content
    json("updated") = "now"
    println(json)

    //write to a new file
    val fn=os.temp.dir() / "updated.json"
    os.write(fn, ujson.write(json))
    println(s"See $fn")

  /**
   * Write an object as JSON to file
   */
  private def test2():Unit=
    logger.info("==>test2")
    val petOwner = PetOwner("Peter", List("Toolkitty", "Scaniel"))

    //write to a new file
    val fn=os.temp.dir() / "updated.json"
    os.write(fn, write(petOwner))
    println(s"See $fn")

  def main(args: Array[String]): Unit = {
    logger.info("==>main")
    test1()
    test2()
  }
