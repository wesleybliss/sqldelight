package com.test

import com.squareup.sqldelight.EnumColumnAdapter;

class User(
    private val id: Long,
    private val firstName: String,
    private val middleInitial: String,
    private val lastName: String,
    private val age: Int,
    private val gender: User.Gender
) : UserModel {
  enum class Gender {
    MALE, FEMALE, OTHER
  }

  override fun id() = id
  override fun first_name() = firstName
  override fun middle_initial() = middleInitial
  override fun last_name() = lastName
  override fun age() = age
  override fun gender() = gender

  companion object {
    val GENDER_ADAPTER = EnumColumnAdapter.create(Gender::class.java);
    val MAPPER: UserModel.Mapper<User> = UserModel.Mapper(::User, GENDER_ADAPTER)
  }
}

class Marshal : UserModel.Marshal<Marshal>(User.GENDER_ADAPTER) {

}
