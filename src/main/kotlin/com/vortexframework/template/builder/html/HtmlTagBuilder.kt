package com.vortexframework.template.builder.html

open class HtmlTagBuilder: HtmlTemplateBuilder() {
    fun header(init: HtmlHeaderBuilder.() -> Unit) = addTagWithBody(HtmlHeaderBuilder(), init, "header")
    fun body(init: HtmlBodyBuilder.() -> Unit) = addTagWithBody(HtmlBodyBuilder(), init, "body")
}