package com.vortexframework.template.builder.html.element

import com.vortexframework.template.TemplateElement

class HtmlTagTemplateElement(private val name: String, private val isSelfClosed: Boolean, private val isInline: Boolean,
                             private val attributes: HashMap<String, String> = HashMap(),
                             private val childElements: List<TemplateElement> = ArrayList(0)): TemplateElement {
    override fun build(): String {
        return buildString {
            append("<$name")
            if (attributes.isNotEmpty()) {
                append(" ")
                append(attributes.map {
                    if (it.value.isEmpty()) {
                        it.key
                    } else {
                        "${it.key}=\"${it.value}\""
                    }
                }.joinToString(" "))
            }
            if (isSelfClosed) {
                append("/>")
            } else if (isInline) {
                append(">")
            } else {
                append(">${childElements.joinToString("") { it.build() }}</$name>")
            }
        }
    }

    override fun toString(): String {
        return build()
    }

}