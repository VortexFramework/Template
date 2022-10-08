package com.vortexframework.template.builder.html

import com.vortexframework.template.builder.html.element.HtmlTagTemplateElement
import com.vortexframework.template.builder.text.element.TextTemplateElement
import com.vortexframework.template.hashMapOfIgnoreNulls

class HtmlHeaderBuilder: HtmlTemplateBuilder() {
    fun link(rel: String? = null, href: String? = null) {
        elements.add(HtmlTagTemplateElement("link", isSelfClosed = true, isInline = true,
            attributes = hashMapOfIgnoreNulls(
                "rel" to rel,
                "href" to href
            )
        ))
    }

    fun script(src: String? = null) {
        elements.add(HtmlTagTemplateElement("script", isSelfClosed = false, isInline = false,
            attributes = hashMapOfIgnoreNulls(
                "src" to src,
            )
        ))
    }

    fun withStyles(vararg cssLinks: String) {
        for (cssLink in cssLinks) {
            link(rel="stylesheet", href=cssLink)
        }
    }

    fun withJavascript(vararg jsLinks: String) {
        for (jsLink in jsLinks) {
            script(src=jsLink)
        }
    }

    fun inlineStyle(style: String) {

    }

    fun inlineJavascript(javascript: String) {

    }

    fun title(title: String) {
        elements.add(HtmlTagTemplateElement("title", isSelfClosed = false, isInline = false, childElements = arrayListOf(
            TextTemplateElement(title)
        )))
    }
}