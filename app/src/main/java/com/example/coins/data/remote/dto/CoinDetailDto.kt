package com.example.coins.data.remote.dto

import com.example.coins.domain.models.CoinDetail

data class CoinDetailDto(
    var description: String,
    var developmentStatus: String,
    var firstDataAt: String,
    var hardwareWallet: Boolean,
    var hashAlgorithm: String,
    var id: String,
    var is_active: Boolean,
    var isNew: Boolean,
    var lastDataAt: String,
    var links: Links,
    var linksExtended: List<LinksExtended>,
    var logo: String,
    var message: String,
    var name: String,
    var openSource: Boolean,
    var orgStructure: String,
    var proofType: String,
    var rank: Int,
    var startedAt: String,
    var symbol: String,
    var tags: List<Tag>,
    var team: List<TeamMember>,
    var type: String,
    var whitePaper: Whitepaper
)

fun CoinDetailDto.toCoinDetail(): CoinDetail{

    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = is_active,
        tags = tags.map { it.name },
        team = team
    )
}