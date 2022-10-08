package com.vortexframework.template.builder.text

import com.vortexframework.template.builder.TemplateBuilder
import com.vortexframework.template.builder.text.element.TextTemplateElement

open class TextTemplateBuilder: TemplateBuilder() {
    operator fun plusAssign(text: String) {
        elements.add(TextTemplateElement(text))
    }


}