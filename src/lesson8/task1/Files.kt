@file:Suppress("UNUSED_PARAMETER")
package lesson8.task1

import java.io.File
import java.io.IOException

/**
 * Пример
 *
 * Во входном файле с именем inputName содержится некоторый текст.
 * Вывести его в выходной файл с именем outputName, выровняв по левому краю,
 * чтобы длина каждой строки не превосходила lineLength.
 * Слова в слишком длинных строках следует переносить на следующую строку.
 * Слишком короткие строки следует дополнять словами из следующей строки.
 * Пустые строки во входном файле обозначают конец абзаца,
 * их следует сохранить и в выходном файле
 */
fun alignFile(inputName: String, lineLength: Int, outputName: String) {
    val outputStream = File(outputName).bufferedWriter()
    var currentLineLength = 0
    for (line in File(inputName).readLines()) {
        if (line.isEmpty()) {
            outputStream.newLine()
            if (currentLineLength > 0) {
                outputStream.newLine()
                currentLineLength = 0
            }
            continue
        }
        for (word in line.split(" ")) {
            if (currentLineLength > 0) {
                if (word.length + currentLineLength >= lineLength) {
                    outputStream.newLine()
                    currentLineLength = 0
                }
                else {
                    outputStream.write(" ")
                    currentLineLength++
                }
            }
            outputStream.write(word)
            currentLineLength += word.length
        }
    }
    outputStream.close()
}

/**
 * Средняя
 *
 * Во входном файле с именем inputName содержится некоторый текст.
 * На вход подаётся список строк substrings.
 * Вернуть ассоциативный массив с числом вхождений каждой из строк в текст.
 * Регистр букв игнорировать, то есть буквы е и Е считать одинаковыми.
 *
 */
fun countSubstrings(inputName: String, substrings: List<String>): Map<String, Int> = TODO()


/**
 * Средняя
 *
 * В русском языке, как правило, после букв Ж, Ч, Ш, Щ пишется И, А, У, а не Ы, Я, Ю.
 * Во входном файле с именем inputName содержится некоторый текст на русском языке.
 * Проверить текст во входном файле на соблюдение данного правила и вывести в выходной
 * файл outputName текст с исправленными ошибками.
 *
 * Регистр заменённых букв следует сохранять.
 *
 * Исключения (жюри, брошюра, парашют) в рамках данного задания обрабатывать не нужно
 *
 */
fun sibilants(inputName: String, outputName: String) {
    TODO()
}

/**
 * Средняя
 *
 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 * Вывести его в выходной файл с именем outputName, выровняв по центру
 * относительно самой длинной строки.
 *
 * Выравнивание следует производить путём добавления пробелов в начало строки.
 *
 *
 * Следующие правила должны быть выполнены:
 * 1) Пробелы в начале и в конце всех строк не следует сохранять.
 * 2) В случае невозможности выравнивания строго по центру, строка должна быть сдвинута в ЛЕВУЮ сторону
 * 3) Пустые строки не являются особым случаем, их тоже следует выравнивать
 * 4) Число строк в выходном файле должно быть равно числу строк во входном (в т. ч. пустых)
 *
 */
fun centerFile(inputName: String, outputName: String) {
    TODO()
}

/**
 * Сложная
 *
 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 * Вывести его в выходной файл с именем outputName, выровняв по левому и правому краю относительно
 * самой длинной строки.
 * Выравнивание производить, вставляя дополнительные пробелы между словами: равномерно по всей строке
 *
 * Слова внутри строки отделяются друг от друга одним или более пробелом.
 *
 * Следующие правила должны быть выполнены:
 * 1) Каждая строка входного и выходного файла не должна начинаться или заканчиваться пробелом.
 * 2) Пустые строки или строки из пробелов трансформируются в пустые строки без пробелов.
 * 3) Строки из одного слова выводятся без пробелов.
 * 4) Число строк в выходном файле должно быть равно числу строк во входном (в т. ч. пустых).
 *
 * Равномерность определяется следующими формальными правилами:
 * 5) Число пробелов между каждыми двумя парами соседних слов не должно отличаться более, чем на 1.
 * 6) Число пробелов между более левой парой соседних слов должно быть больше или равно числу пробелов
 *    между более правой парой соседних слов.
 *
 * Следует учесть, что входной файл может содержать последовательности из нескольких пробелов  между слвоами. Такие
 * последовательности следует учитывать при выравнивании и при необходимости избавляться от лишних пробелов.
 * Из этого следуют следующие правила:
 * 7) В самой длинной строке каждая пара соседних слов должна быть отделена В ТОЧНОСТИ одним пробелом
 * 8) Если входной файл удовлетворяет требованиям 1-7, то он должен быть в точности идентичен выходному файлу
 */
fun alignFileByWidth(inputName: String, outputName: String) {
    TODO()
}

/**
 * Средняя
 *
 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 *
 * Вернуть ассоциативный массив, содержащий 20 наиболее часто встречающихся слов с их количеством.
 * Если в тексте менее 20 различных слов, вернуть все слова.
 *
 * Словом считается непрерывная последовательность из букв (кириллических,
 * либо латинских, без знаков препинания и цифр).
 * Регистр букв игнорировать, то есть буквы е и Е считать одинаковыми.
 * Ключи в ассоциативном массиве должны быть в нижнем регистре.
 *
 */
fun top20Words(inputName: String): Map<String, Int> = TODO()

/**
 * Средняя
 *
 * Реализовать транслитерацию текста из входного файла в выходной файл посредством динамически задаваемых правил.

 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 *
 * В ассоциативном массиве dictionary содержится словарь, в котором некоторым символам
 * ставится в соответствие строчка из символов, например
 * mapOf('з' to "zz", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "yy", '!' to "!!!")
 *
 * Необходимо вывести в итоговый файл с именем outputName
 * содержимое текста с заменой всех символов из словаря на соответствующие им строки.
 *
 * При этом регистр символов в словаре должен игнорироваться,
 * но при выводе символ в верхнем регистре отображается в строку, начинающуюся с символа в верхнем регистре.
 *
 * Пример.
 * Входной текст: Здравствуй, мир!
 *
 * заменяется на
 *
 * Выходной текст: Zzdrавствуy, mир!!!
 *
 * Обратите внимание: данная функция не имеет возвращаемого значения
 */
fun transliterate(inputName: String, dictionary: Map<Char, String>, outputName: String) {
    TODO()
}

/**
 * Средняя
 *
 * Во входном файле с именем inputName имеется словарь с одним словом в каждой строчке.
 * Выбрать из данного словаря наиболее длинное слово,
 * в котором все буквы разные, например: Неряшливость, Четырёхдюймовка.
 * Вывести его в выходной файл с именем outputName.
 * Если во входном файле имеется несколько слов с одинаковой длиной, в которых все буквы разные,
 * в выходной файл следует вывести их все через запятую.
 * Регистр букв игнорировать, то есть буквы е и Е считать одинаковыми.
 *
 * Пример входного файла:
 * Карминовый
 * Боязливый
 * Некрасивый
 * Остроумный
 * БелогЛазый
 * ФиолетОвый

 * Соответствующий выходной файл:
 * Карминовый, Некрасивый
 *
 * Обратите внимание: данная функция не имеет возвращаемого значения
 */
fun chooseLongestChaoticWord(inputName: String, outputName: String) {
    TODO()
}

/**
 * Сложная
 *
 * Реализовать транслитерацию текста в заданном формате разметки в формат разметки HTML.
 *
 * Во входном файле с именем inputName содержится текст, содержащий в себе элементы текстовой разметки следующих типов:
 * - *текст в курсивном начертании* -- курсив
 * - **текст в полужирном начертании** -- полужирный
 * - ~~зачёркнутый текст~~ -- зачёркивание
 *
 * Следует вывести в выходной файл этот же текст в формате HTML:
 * - <i>текст в курсивном начертании</i>
 * - <b>текст в полужирном начертании</b>
 * - <s>зачёркнутый текст</s>
 *
 * Кроме того, все абзацы исходного текста, отделённые друг от друга пустыми строками, следует обернуть в теги <p>...</p>,
 * а весь текст целиком в теги <html><body>...</body></html>.
 *
 * Все остальные части исходного текста должны остаться неизменными с точностью до наборов пробелов и переносов строк.
 * Отдельно следует заметить, что открывающая последовательность из трёх звёздочек (***) должна трактоваться как "<b><i>"
 * и никак иначе.
 *
 * Пример входного файла:
Lorem ipsum *dolor sit amet*, consectetur **adipiscing** elit.
Vestibulum lobortis, ~~Est vehicula rutrum *suscipit*~~, ipsum ~~lib~~ero *placerat **tortor***,

Suspendisse ~~et elit in enim tempus iaculis~~.
 *
 * Соответствующий выходной файл:
<html>
    <body>
        <p>
            Lorem ipsum <i>dolor sit amet</i>, consectetur <b>adipiscing</b> elit.
            Vestibulum lobortis. <s>Est vehicula rutrum <i>suscipit</i></s>, ipsum <s>lib</s>ero <i>placerat <b>tortor</b></i>.
        </p>
        <p>
            Suspendisse <s>et elit in enim tempus iaculis</s>.
        </p>
    </body>
</html>
 *
 * (Отступы и переносы строк в примере добавлены для наглядности, при решении задачи их реализовывать не обязательно)
 */
fun markdownToHtmlSimple(inputName: String, outputName: String) {
    TODO()
}

/**
 * Сложная
 *
 * Реализовать транслитерацию текста в заданном формате разметки в формат разметки HTML.
 *
 * Во входном файле с именем inputName содержится текст, содержащий в себе набор вложенных друг в друга списков.
 * Списки бывают двух типов: нумерованные и ненумерованные.
 *
 * Каждый элемент ненумерованного списка начинается с новой строки и символа '*', каждый элемент нумерованного списка --
 * с новой строки, числа и точки. Каждый элемент вложенного списка начинается с отступа из пробелов, на 4 пробела большего,
 * чем список-родитель. Максимально глубина вложенности списков может достигать 6. "Верхние" списки файла начинются
 * прямо с начала строки.
 *
 * Следует вывести этот же текст в выходной файл в формате HTML:
 * Нумерованный список:
 * <ol>
 *     <li>Раз</li>
 *     <li>Два</li>
 *     <li>Три</li>
 * </ol>
 *
 * Ненумерованный список:
 * <ul>
 *     <li>Раз</li>
 *     <li>Два</li>
 *     <li>Три</li>
 * </ul>
 *
 * Кроме того, весь текст целиком следует обернуть в теги <html><body>...</body></html>
 *
 * Все остальные части исходного текста должны остаться неизменными с точностью до наборов пробелов и переносов строк.
 *
 * Пример входного файла:
///////////////////////////////начало файла/////////////////////////////////////////////////////////////////////////////
* Утка по-пекински
    * Утка
    * Соус
* Салат Оливье
    1. Мясо
        * Или колбаса
    2. Майонез
    3. Картофель
    4. Что-то там ещё
* Помидоры
* Фрукты
    1. Бананы
    23. Яблоки
        1. Красные
        2. Зелёные
///////////////////////////////конец файла//////////////////////////////////////////////////////////////////////////////
 *
 *
 * Соответствующий выходной файл:
///////////////////////////////начало файла/////////////////////////////////////////////////////////////////////////////
<html>
  <body>
    <ul>
      <li>
        Утка по-пекински
        <ul>
          <li>Утка</li>
          <li>Соус</li>
        </ul>
      </li>
      <li>
        Салат Оливье
        <ol>
          <li>Мясо
            <ul>
              <li>
                  Или колбаса
              </li>
            </ul>
          </li>
          <li>Майонез</li>
          <li>Картофель</li>
          <li>Что-то там ещё</li>
        </ol>
      </li>
      <li>Помидоры</li>
      <li>
        Яблоки
        <ol>
          <li>Красные</li>
          <li>Зелёные</li>
        </ol>
      </li>
    </ul>
  </body>
</html>
///////////////////////////////конец файла//////////////////////////////////////////////////////////////////////////////
 * (Отступы и переносы строк в примере добавлены для наглядности, при решении задачи их реализовывать не обязательно)
 */
fun markdownToHtmlLists(inputName: String, outputName: String) {
    TODO()
}

/**
 * Очень сложная
 *
 * Реализовать преобразования из двух предыдущих задач одновременно над одним и тем же файлом.
 * Следует помнить, что:
 * - Списки, отделённые друг от друга пустой строкой, являются разными и должны оказаться в разных параграфах выходного файла.
 *
 */
fun markdownToHtml(inputName: String, outputName: String) {
    TODO()
}

/**
 * Средняя
 *
 * Вывести в выходной файл процесс умножения столбиком числа lhv (> 0) на число rhv (> 0).
 *
 * Пример (для lhv == 19935, rhv == 111):
   19935
*    111
--------
   19935
+ 19935
+19935
--------
 2212785
 * Используемые пробелы, отступы и дефисы должны в точности соответствовать примеру.
 * Нули в множителе обрабатывать так же, как и остальные цифры:
  235
*  10
-----
    0
+235
-----
 2350
 *
 */
fun printMultiplicationProcess(lhv: Int, rhv: Int, outputName: String) {
    TODO()
}


/**
 * Очень сложная
 *
 * Вывести в выходной файл процесс деления столбиком числа lhv (> 0) на число rhv (> 0).
 *
 * Пример (для lhv == 19935, rhv == 22):
  19935 | 22
 -198     906
 ----
    13
    -0
    --
    135
   -132
   ----
      3

 * Используемые пробелы, отступы и дефисы должны в точности соответствовать примеру.
 *
 */
fun printDivisionProcess(lhv: Int, rhv: Int, outputName: String) {
    TODO()
}



fun mnojestva(inputName: String, expr: String): String {
    if (!File(inputName).canRead()) throw IOException()
    if (!expr.matches(Regex("([A-Z])+ +&+ +([A-Z])"))) throw IllegalArgumentException("кек")
    val inputlist = File(inputName).readLines()
    val expr1 = expr.substring(0,1)
    val expr2 = expr.substring(4,5)
    var nujmnoj1 = ""
    var nujmnoj2 = ""
    try {
        for (lines in inputlist) {
            if (!lines.matches(Regex("([A-Z])+ +=+(( +\\d+,)+)+ +\\d"))) throw IllegalArgumentException("кек")
            val mnoj = lines.split("=")
            if (mnoj[0].substring(0, 1).toString() == expr1.toString() || mnoj[0].substring(0, 1).toString() == expr2.toString()) {
                if (nujmnoj1 == "") nujmnoj1 = mnoj[1] else nujmnoj2 = mnoj[1]
            }
        }
        val splitnujmnoj1 = nujmnoj1.split(",")
        val splitnujmnoj2 = nujmnoj2.split(",")
        var result = ""
        for (a in splitnujmnoj1) {
            for (b in splitnujmnoj2) {
                if (a.trim().toInt() == b.trim().toInt()) result += a
            }
        }
        return result.trim()
    } catch (e: NumberFormatException) {

        throw IllegalArgumentException("кек")
    }

}

fun telepona2(inputName: String, query: String): String {
    if (!File(inputName).canRead()) throw IllegalArgumentException()
    val inputlist = File(inputName).readLines()
    val queryname = query.split(" ")
    val asd = queryname[0]
    if (queryname.size != 2 || queryname[1].contains(Regex("""[^а-яА-я]""")) || queryname[0].contains(Regex("""[^а-яА-я]""")) )
        throw IllegalArgumentException()
    val ppp = queryname[1]
    val result = "Нет номера"
    for (line  in inputlist) {
        val contact = line.split(":")
        val dsaf = contact[0]
        val adsf = contact[0].substring(0,contact[0].length - 1)
        if (contact[0].substring(0,contact[0].length - 1) == queryname[0])  {
            val nambers = contact[1].split(",")
            for (sublines in nambers) {
                val subsub = sublines.trim().split(" ")
                val sdf = subsub[1].substring(1,subsub[1].length-1)
                if (ppp == sdf) return subsub[0]
            }
        }
    }

return result

}

fun srednee3(inputName: String, range: String): Double {
    val startstolb = translate(range.split(":")[0].first())
    val stopstolb = translate(range.split(":")[1].first())
    val elem = File(inputName).readLines()[range.split(":")[0].last().toString().toInt() - 1].split(",")
    var n = 0
    var result = 0.0
    while (n <= stopstolb) {
        if (n >= startstolb) result += elem[n - 1].toDouble()
        n ++
    }
    return result
}


fun translate(a: Char): Int {
    val alfavit = "abcdefghijklmnopqrstuvwxyz"
    return alfavit.indexOf(a.toLowerCase(), 0) + 1
}

fun osadki4(inputName: String, days :String): Int {
    val inputlist = File(inputName).readLines()
    val start = days.split(" ")[1].split("..")[0].toInt()
    val stop = days.split(" ")[1].split("..")[1].toInt()
    var max = 0
    for (lines in inputlist) {
        if (lines.split(" ")[0] == days.split(" ")[0] ) {
            var n = 0
            while (n <= stop) {
                if (n >= start) if (lines.split(" ")[n].toInt() > max) max = lines.split(" ")[n].toInt()
                n ++
            }
        }
    }
    return max
}

fun product5(inputName: String, query: String): String{
    val inputlist = File(inputName).readLines()
    for (lines in inputlist) {
        if (lines.split(":")[0] == query.split(" ")[0]) {
            val kolvo = lines.split(":")[1].trim().split(",")[2].trim().split(" ")[0].trim().toInt()
            val cena = lines.split(":")[1].trim().split(",")[1].trim().split(" ")[0].trim().toInt()
            if (kolvo >= query.split(" ")[1].toInt())
                return "Достатачно Цена: " + (query.split(" ")[1].toInt() * cena.toString().toInt())
        }

    }
    return "Недостатачно"
}

fun sport6(inputName: String):String {
    if (!File(inputName).canRead()) throw IllegalArgumentException("Ну че где твоя таблица-то, блять?")
    val inputlist = File(inputName).readLines()
    var n = 1
    var result =""
    try {
        for (lines in inputlist) {
            if (!lines.matches(Regex("([А-я])\\W+(\\d+ )+\\d"))) throw IllegalArgumentException("Лашпед! таблицу перделай, мудень, блять")
            val komanda = lines.split(" ")[0]
            var zabito = 0
            var propysheno = 0
            for (a in 1..inputlist.size) {
                zabito += lines.split(" ")[a].trim().toInt()
                propysheno += inputlist[a - 1].split(" ")[n].toInt()
                if ((a == n) && (lines.split(" ")[a].trim().toInt() != 0) && (inputlist[a - 1].split(" ")[n].toInt() != 0)) throw IllegalArgumentException("Хуйку сасика")
            }
            result += komanda + " Забито: " + zabito + " Пропущено: " + propysheno + " / "
            n++

        }
    } catch (e: IndexOutOfBoundsException ) {
        throw IllegalArgumentException("Ну ты и тупой")
    }
        return result.trim()
    }

fun samoleti(inputName: String, src: String, dst: String): String {
    if (!File(inputName).canRead()) throw IllegalArgumentException()
    val inputlist = File(inputName).readLines()
    var indicator = 0
    for (lines in inputlist) {
        if (!lines.matches(Regex("\\d+ +(([А-я])\\W)+[<>]+.*"))) throw IllegalArgumentException()
        if (lines.split(" ")[3].toString().length != 5) throw IllegalArgumentException()
        if (lines.split(" ")[1] == src && lines.split(" ")[2] == ">") indicator ++
        if (lines.split(" ")[1] == dst && lines.split(" ")[2] == "<") indicator ++
    }
    if (indicator >= 2) return "Да"
    return "Сидидома дебил"
}

fun kvartiri(inputName: String, query: String): String{
    val inputlist = File(inputName).readLines()
    var result = ""
    for (lines in inputlist) {
        val kvartira = lines.split(":")[1].trim().split(",")
        for (komnati in kvartira) {
            if (komnati.trim().split(" ")[0] == query.split(" ")[0] && komnati.trim().split(" ")[1].toInt() >= query.split(" ")[1].toInt())
                result += lines.split(":")[0] + " "

        }
    }
    if (result.isNotEmpty()) return result
    return "живи на улице с такими запросами"
}



























