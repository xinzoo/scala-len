package cn.xinzoo.scala.highorder

object FileMatcher {
  private def filesPath(path:String) = new java.io.File(path).listFiles()

  def filesEnding(path:String,query:String) =
    for (file <- filesPath(path);if file.getName.endsWith(query))
      yield file

  def filesContaining(path:String,query:String) =
    for (file <- filesPath(path);if file.getName.contains(query))
      yield file

  def filesRegex(path:String,query:String) =
    for (file <- filesPath(path);if file.getName.matches(query))
      yield file

  def filesMatching(path:String,
                    matcher:String => Boolean)={
    for (file <- filesPath(path);if matcher(file.getName))
      yield file
  }

  def filesEndingShort(path:String,query:String)=
    filesMatching(path,_.endsWith(query))

  def filesContainingShort(path:String,query:String)=
    filesMatching(path,_.contains(query))

  def filesRegexShort(path:String,query:String)=
    filesMatching(path,_.matches(query))

  def main(args: Array[String]): Unit = {
    val path = "E:\\workspace\\spark-myex\\src\\main\\scala\\cn\\xinzoo\\spark\\ex"
    val files = FileMatcher.filesContaining(path,"scala")
    val files1 = FileMatcher.filesEndingShort(path,"scala")
    for (f <- files1)println(f.getName)
  }
}
