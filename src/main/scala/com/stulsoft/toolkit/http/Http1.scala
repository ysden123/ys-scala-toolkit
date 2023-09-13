/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.toolkit.http

import sttp.client4.quick.*
import sttp.client4.Response

import com.typesafe.scalalogging.StrictLogging

/**
 * Sending HTTP request
 *
 * @see [[https://docs.scala-lang.org/toolkit/http-client-request.html#sending-an-http-request]]
 */
object Http1 extends StrictLogging:
  private def test1(): Unit =
    logger.info("==>test1")
    val response: Response[String] = quickRequest
      .get(uri"https://httpbin.org/get")
      .send()

    println(response.code)
    // prints: 200

    println(response.body)
    // prints some JSON string

    println(response.body)

    val jsonObject= ujson.read(response.body)
    jsonObject.update("new_field", "It is a new field")
    println(jsonObject)

  def main(args: Array[String]): Unit = {
    logger.info("==>main")
    test1()
  }
