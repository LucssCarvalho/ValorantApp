package com.carvalho.valorantinfo.model

data class Agent(
    val uuid: String,
    val displayName: String,
    val description: String,
    val developerName: String,
    val releaseDate: String,
    val characterTags: List<String>?,
    val displayIcon: String,
    val displayIconSmall: String,
    val bustPortrait: String,
    val fullPortrait: String,
    val fullPortraitV2: String,
    val killfeedPortrait: String,
    val background: String,
    val backgroundGradientColors: List<String>,
    val assetPath: String,
    val isFullPortraitRightFacing: Boolean,
    val isPlayableCharacter: Boolean,
    val isAvailableForTest: Boolean,
    val isBaseContent: Boolean,
    val role: Role,
    val recruitmentData: RecruitmentData?,
    val abilities: List<Ability>,
    val voiceLine: String?
)

data class Role(
    val uuid: String,
    val displayName: String,
    val description: String,
    val displayIcon: String,
    val assetPath: String
)

data class Ability(
    val slot: String,
    val displayName: String,
    val description: String,
    val displayIcon: String
)

data class RecruitmentData(
    val isRecruitable: Boolean,
    val cost: Int
)