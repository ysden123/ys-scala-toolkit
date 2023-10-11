/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.toolkit.process

import com.typesafe.scalalogging.StrictLogging
import os.Path

import scala.sys.process.*

/**
 * Demonstrates an example of the usage the running an external process.
 * In this example we silently delete non empty directory
 */
object DelDirSilently extends StrictLogging:
  private def buildTestDir(): Path =
    logger.info("==>buildTestDir")
    val testDirPath = os.temp.dir()

    os.write(testDirPath / "f1.txt", "test1")

    os.makeDir(testDirPath / "dir1")
    os.write(testDirPath / "dir1" / "f2.txt", "test2")

    os.makeDir(testDirPath / "dir2")
    os.write(testDirPath / "dir2" / "f2.txt", "test3")

    testDirPath
  end buildTestDir

  private def listTestDir(testDirPath: Path): Unit =
    os.exists(testDirPath)
    logger.info("==>listTestDir testDirPath:{}", testDirPath)
    if os.exists(testDirPath) then
      os.walk(testDirPath).foreach(p => logger.info("{}", p))
    else
      logger.info("{} does not exist", testDirPath)
  end listTestDir

  private def deleteTestDir(path: Path): Unit =
    logger.info("==>deleteTestDir")
    // rmdir dir /s /q
    val command = Seq("cmd", "/c", "rmdir",
      s""""${path.toString}"""",
      "/s", "/q")
    try
      logger.info("Running {}", command.mkString(" "))
      val result = command.!!
      logger.info("Result: {}", result)
    catch
      case exception: Exception =>
        logger.error(exception.getMessage, exception)
  end deleteTestDir

  def main(args: Array[String]): Unit =
    logger.info("==>main")
    val testDirPath = buildTestDir()
    listTestDir(testDirPath)
    deleteTestDir(testDirPath)
    listTestDir(testDirPath)
  end main

end DelDirSilently

