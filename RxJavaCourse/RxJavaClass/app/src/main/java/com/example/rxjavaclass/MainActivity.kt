package com.example.rxjavaclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*createFromArray().subscribe() {
                arr -> println("received arrays is :" + Arrays.toString(arr))
        }*/

        /*createFromIterable().subscribe { a ->
            println("received data is: " + a)
        }*/

        /*createRange().subscribe {
            a -> println("received data is : " + a)
        }*/

        /*createTimer().subscribe() {
                a -> println("The food is ready after : " + a)
        }*/

        /*createFilter().subscribe {
            a -> println("The data received is : " + a)
        }*/

        /*createTakeLast().subscribe {
            a -> println("The data received is : " + a)
        }*/

        /*createTake().subscribe {
                a -> println("The data received is : " + a)
        }*/

        /*createTimeOut("reem").subscribe(
            {
                // when onNext method
                name -> println("Hello " + name)
            }, {
                // when onError called
                throwable -> println("you have an error in : " + throwable.javaClass.simpleName)
            }
        )*/

        /*createDistinct().subscribe(
            {
                value -> println("value is : " + value)
            }, {
                throwable -> println("You have an error in : " + throwable.javaClass.simpleName)
            }
        )*/

        /*createStartWith().subscribe(
            {
                    name -> println("name is : " + name)
            }, {
                    throwable -> println("You have an error in : " + throwable.javaClass.simpleName)
            }
        )*/

        /*createMerge().subscribe(
            {
                    value -> println("value is : " + value)
            }, {
                    throwable -> println("You have an error in : " + throwable.javaClass.simpleName)
            }
        )*/

        /*createConcat().subscribe(
            {
                    value -> println("value is : " + value)
            }, {
                    throwable -> println("You have an error in : " + throwable.javaClass.simpleName)
            }
        )*/

        /*createZip().subscribe(
            {
                    value -> println("value is : " + value)
            }, {
                    throwable -> println("You have an error in : " + throwable.javaClass.simpleName)
            }
        )*/

        /*createMap().subscribe(
            {
                    value -> println("value is : " + value)
            }, {
                    throwable -> println("You have an error in : " + throwable.javaClass.simpleName)
            }
        )*/

        /*createFlatMap().subscribe(
            {
                    name -> println("name is : " + name)
            }, {
                    throwable -> println("You have an error in : " + throwable.javaClass.simpleName)
            }
        )*/

        /*val professor = PublishSubject.create<String>()
        professor.subscribe(getFirstStudent())

        // lecture has begun

        professor.onNext("kotlin")
        professor.onNext("java")
        professor.onNext("c++")

        // new student has entered the classroom

        professor.subscribe(getLateStudent())
        professor.onNext("scala")
        professor.onComplete()*/

        /*val professor = ReplaySubject.create<String>()
        professor.subscribe(getFirstStudent())
        professor.onNext("kotlin")
        professor.onNext("java")
        professor.onNext("c++")
        professor.subscribe(getLateStudent())
        professor.onNext("scala")
        professor.onComplete()*/

        /*val professor = BehaviorSubject.create<String>()*/ // LateStudent will get the recent value and the rest of values

        /*val professor = AsyncSubject.create<String>() // Every student will get the last value and complete the lesson (first one then second one etc)
        professor.subscribe(getFirstStudent())
        professor.onNext("kotlin")
        professor.onNext("java")
        professor.onNext("c++")
        professor.subscribe(getLateStudent())
        professor.onNext("scala")
        professor.onComplete()*/

        myGithubStarsRepos.setOnClickListener {
            startActivity(Intent(applicationContext, MyStarsRepos::class.java))
        }
    }

    /*private fun showJustJob() {
        val dataStream = Observable.just(10, 20, 30, 40)
        val dataObserver = object: Observer<Int> {
            override fun onComplete() {
                println("All data is received")
            }

            override fun onSubscribe(d: Disposable?) {

            }

            override fun onNext(t: Int?) {
                println("new data is received :" + t.toString())
            }

            override fun onError(e: Throwable?) {
                println("An Error is received" + e?.message)
            }
        }

        dataStream.subscribe(dataObserver)
    }*/

    private fun createFromArray(): Observable<Array<Int>> {
        return Observable.fromArray(arrayOf(1, 5, 7, 9))
    }

    private fun createFromIterable() : Observable<Int> {
        return Observable.fromIterable(mutableListOf(2, 5, 7))
    }

    private fun createRange() : Observable<Int> {
        return Observable.range(1, 3).repeat(3)
    }

    private fun createInterval() : Observable<Long> {
        return Observable.interval(1, TimeUnit.SECONDS).takeWhile {value -> value < 20}
    }

    private fun createTimer() :  Observable<Long> {
        return Observable.timer(5, TimeUnit.SECONDS)
    }

    private fun createFilter() : Observable<Int> {
        return Observable.just(2, 40, 30, 5)
            .filter {x -> x > 10}
    }

    private fun createTakeLast (): Observable<Int> {
        return Observable.just(2, 40, 30, 5)
            .takeLast(2)
    }

    private fun createTake (): Observable<Int> {
        return Observable.just(2, 40, 30, 5)
            .take(2)
    }

    private fun createTimeOut (name: String): Observable<String> {
        return Observable.fromCallable {
            if (name.equals("ramadan"))
                Thread.sleep(150)
            name
        }.timeout(100, TimeUnit.MILLISECONDS)
    }

    private fun createDistinct(): Observable<Int> {
        return Observable.just(1, 2, 2, 2, 4, 5, 5)
            .distinct()
    }

    private fun createStartWith(): Observable<String> {
        return Observable.just("ramadan", "mohamed", "ahmed").startWith("Reem")
    }

    private fun createMerge(): Observable<Int> {
        val firstStream = Observable.just(1, 3, 2,1, 2)
        val secondStream = Observable.just(5,6)

        /*return Observable.merge(firstStream, secondStream)*/
        return firstStream.mergeWith(secondStream)
    }

    private fun createConcat(): Observable<Int> {
        val firstStream = Observable.just(1, 3, 2, 1, 2)
        val secondStream = Observable.just(5,6, 1)

        return firstStream.concatWith(secondStream)
    }

    private fun createZip(): Observable<String> {
        val firstNames = Observable.just("Mohamed", "Ahmed", "Mahmoud")
        val lastNames = Observable.just("ramadan", "yousuf", "omar")
        return firstNames.zipWith(lastNames, BiFunction { first, last ->
            first + " " + last
        })
    }

    private fun createMap(): Observable<Int> {
        return Observable.just(1,2, 3, 4, 5)
            .map { value -> value*10 }
    }

    private fun createFlatMap(): Observable<String> {
        return Observable.just("x0111111", "x987878787", "yt56565656")
            .flatMap {
                    id -> getName(id)
            }
    }

    private fun getName(id: String): Observable<String> {
        val names = arrayOf("ramadan", "hashem", "Yousef")
        val rand = Random().nextInt(3)
        println(rand)
        return Observable.just(names[rand])
    }

    /*private fun getFirstStudent():Observer<String> {
        return object: Observer<String> {
            override fun onComplete() {
                println("the lecture is ended")
            }

            override fun onSubscribe(d: Disposable?) {

            }

            override fun onNext(t: String?) {
                println("first student >> our professor teach us about : " + t)
            }

            override fun onError(e: Throwable?) {
                println("error")
            }

        }
    }*/

    /*private fun getLateStudent():Observer<String> {
        return object: Observer<String> {
            override fun onComplete() {
                println("the lecture is ended")
            }

            override fun onSubscribe(d: Disposable?) {

            }

            override fun onNext(t: String?) {
                println("late student >> our professor teach us about : " + t)
            }

            override fun onError(e: Throwable?) {
                println("error")
            }
        }
    }*/
}