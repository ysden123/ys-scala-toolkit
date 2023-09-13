/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.toolkit.json

import com.typesafe.scalalogging.StrictLogging

object Json5 extends StrictLogging:
  /**
   * Construct a new JSON structure with uJson
   *
   * @see [[https://docs.scala-lang.org/toolkit/json-what-else.html#construct-a-new-json-structure-with-ujson]]
   */
  private def test1(): Unit =
    logger.info("==>test1")
    val obj: ujson.Value = ujson.Obj(
      "library" -> "upickle",
      "versions" -> ujson.Arr("1.6.0", "2.0.0", "3.1.0"),
      "documentation" -> "https://com-lihaoyi.github.io/upickle/",
    )

    println(obj)

  def main(args: Array[String]): Unit = {
    logger.info("==>main")
    test1()
  }
