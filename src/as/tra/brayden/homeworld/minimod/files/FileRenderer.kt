package `as`.tra.brayden.homeworld.minimod.files

import java.awt.Color
import java.awt.Component
import javax.swing.filechooser.FileSystemView
import javax.swing.text.StyleConstants.setIcon
import java.io.File
import javax.swing.JList
import javax.swing.border.EmptyBorder
import javax.swing.DefaultListCellRenderer
import javax.swing.JLabel


internal class FileRenderer(private val pad: Boolean) : DefaultListCellRenderer() {
    private val padBorder = EmptyBorder(3, 3, 3, 3)

    override fun getListCellRendererComponent(
            list: JList<*>,
            value: Any?,
            index: Int,
            isSelected: Boolean,
            cellHasFocus: Boolean): Component {

        val c = super.getListCellRendererComponent(
                list, value, index, isSelected, cellHasFocus)
        val l = c as JLabel
        l.foreground = Color.GRAY
        val f = value as File?
        l.text = f!!.name
        l.icon = FileSystemView.getFileSystemView().getSystemIcon(f)

        if (pad) {
            l.border = padBorder
        }

        return l
    }
}