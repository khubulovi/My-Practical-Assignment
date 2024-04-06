package com.example.myapplication

import android.annotation.SuppressLint
import io.reactivex.rxjava3.core.Observable
import kotlin.random.Random
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import kotlin.text.StringBuilder


const val names = "nodari anzori vazgena ashota kushala mushala zaniuxala"
const val otherNames =
    "nodari anzori jaba vazgena ksusha ashota xrusha kushala mushala lala zaniuxala"
val random = Random(System.currentTimeMillis())

fun createText(): String = ""

@SuppressLint("CheckResult")
fun main() {
    Observable
        .merge(
            Observable.concat(
                Observable.just(names),
                Observable.just(otherNames)
            ),
            Observable.fromCallable(::createText),
        )
        .map { text -> text.split(" ") }
        .concatMap { words -> Observable.fromIterable(words) }
        .distinct()
        .flatMap(::clearAllNotLetterMaps)
        .subscribeOn(Schedulers.computation())
        .subscribe(::onNames, ::onError)

    Thread.sleep(1500)
}

@SuppressLint("CheckResult")
fun clearAllNotLetterMaps(words: String): Observable<String> =
    Observable.fromIterable(words.asIterable())
        .filter(Char::isLetter)
        .observeOn(Schedulers.newThread())
        .reduce(StringBuilder()) { stringBuilder: StringBuilder, char: Char ->
            stringBuilder.append(char)
        }
        .map(StringBuilder::toString)
        .delay(
            random.nextLong(500), TimeUnit.MILLISECONDS, Schedulers.io()
        )
        .toObservable()

fun onNames(name: String) = println(name)

fun onError(error: Throwable) = println(error.localizedMessage)
