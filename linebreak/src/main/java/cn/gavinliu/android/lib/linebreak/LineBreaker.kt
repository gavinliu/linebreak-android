package cn.gavinliu.android.lib.linebreak

object LineBreaker {

    private const val MUSTBREAK = 0
    private const val ALLOWBREAK = 1
    private const val NOBREAK = 2
    private const val INSIDEACHAR = 3
    private const val INDETERMINATE = 4

    init {
        System.loadLibrary("linebreak")
    }

    private external fun breaks(data: String, breaks: ByteArray)

    fun lineBreak(data: String): List<String> {
        val result = ArrayList<String>()

        val array = ByteArray(data.length)
        breaks(data, array)

        var start = 0
        var length = 0
        array.forEachIndexed { _, byte ->
            length++
            when (byte.toInt()) {
                ALLOWBREAK, INDETERMINATE -> {
                    result.add(data.substring(start, start + length))
                    start += length
                    length = 0
                }
            }
        }

        return result
    }

}