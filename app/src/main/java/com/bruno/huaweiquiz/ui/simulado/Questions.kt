package com.bruno.huaweiquiz.ui.simulado

import android.os.Parcel
import android.os.Parcelable

sealed class Question(
    open val question: String,
    open val options: List<String>
) : Parcelable {
    override fun describeContents(): Int = 0
}

data class MultipleChoiceQuestion(
    override val question: String,
    override val options: List<String>,
    val correctAnswers: Set<Int>
) : Question(question, options) {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.createStringArrayList() ?: emptyList(),
        parcel.createIntArray()?.toSet() ?: emptySet()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(question)
        parcel.writeStringList(options)
        parcel.writeIntArray(correctAnswers.toIntArray())
    }

    companion object CREATOR : Parcelable.Creator<MultipleChoiceQuestion> {
        override fun createFromParcel(parcel: Parcel): MultipleChoiceQuestion {
            return MultipleChoiceQuestion(parcel)
        }

        override fun newArray(size: Int): Array<MultipleChoiceQuestion?> {
            return arrayOfNulls(size)
        }
    }
}

data class SingleChoiceQuestion(
    override val question: String,
    override val options: List<String>,
    val correctAnswer: Int
) : Question(question, options) {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.createStringArrayList() ?: emptyList(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(question)
        parcel.writeStringList(options)
        parcel.writeInt(correctAnswer)
    }

    companion object CREATOR : Parcelable.Creator<SingleChoiceQuestion> {
        override fun createFromParcel(parcel: Parcel): SingleChoiceQuestion {
            return SingleChoiceQuestion(parcel)
        }

        override fun newArray(size: Int): Array<SingleChoiceQuestion?> {
            return arrayOfNulls(size)
        }
    }
}

data class TrueFalseQuestion(
    override val question: String,
    override val options: List<String> = listOf("Verdadeiro", "Falso"),
    val correctAnswer: Boolean
) : Question(question, options) {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.createStringArrayList() ?: emptyList(),
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(question)
        parcel.writeStringList(options)
        parcel.writeByte(if (correctAnswer) 1 else 0)
    }

    companion object CREATOR : Parcelable.Creator<TrueFalseQuestion> {
        override fun createFromParcel(parcel: Parcel): TrueFalseQuestion {
            return TrueFalseQuestion(parcel)
        }

        override fun newArray(size: Int): Array<TrueFalseQuestion?> {
            return arrayOfNulls(size)
        }
    }
}