package `as`.tra.brayden.homeworld.minimod.files

import java.awt.Component
import java.io.File
import java.util.*
import javax.swing.*
import javax.swing.DefaultListModel
import java.nio.file.Files.isRegularFile
import java.nio.file.Paths
import java.nio.file.Files
import java.nio.file.Path
import java.util.function.BiPredicate
import java.util.function.Consumer
import java.util.stream.Stream


class Directory(val file: File) {

    fun getListComponent(): Component {
        val fileList = JList(file.listFiles())


        fileList.cellRenderer = FileRenderer(false)


        fileList.visibleRowCount = 9


        return JScrollPane(fileList)


    }

    fun getRecursiveFiles(): Stream<Path> {

        return Files.find(file.toPath(), Integer.MAX_VALUE, BiPredicate { t, u -> u.isRegularFile })
                //.forEach(Consumer<Path> { println(it) })


//        Files.find(file.toPath(), Integer.MAX_VALUE, { filePath, fileAttr -> fileAttr.isRegularFile })
     //           .forEach(Consumer<Path> { println(it) })
    }


}