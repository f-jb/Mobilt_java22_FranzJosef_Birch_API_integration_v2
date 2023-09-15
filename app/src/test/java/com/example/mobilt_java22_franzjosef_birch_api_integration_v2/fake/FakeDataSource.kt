package com.example.mobilt_java22_franzjosef_birch_api_integration_v2.fake

import com.example.mobilt_java22_franzjosef_birch_api_integration_v2.model.Fact

object FakeDataSource {
    private const val id: String = "1"
    private const val text: String = "Dolphins are mammals, hence the breastfeed"
    private const val source: String = "my brain"
    private const val sourceUrl: String = "https://example.com"
    private const val language: String = "en"
    private const val permalink: String = "https://example.com"

    val fact: Fact = Fact(id = id, text = text, source = source, sourceUrl = sourceUrl, language = language, permalink = permalink)

}