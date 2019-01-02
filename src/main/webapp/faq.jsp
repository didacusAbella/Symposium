<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sy:layout title="Symposium-FAQ">
    <jsp:body>
        <div class="grid-x">
            <div class="grid-container">
                <h2>Frequently Asked Question</h2>
                <ul class="accordion" data-accordion data-multi-expand="true">
                    <li class="accordion-item is-active" data-accordion-item>
                        <a href="#" class="accordion-title">Cos'è questo sito?</a>
                        <div class="accordion-content" data-tab-content>
                            <p>
                                Questo sito desidera supportare lo studente 
                                iscritto alla facoltà di Informatica dell'Università 
                                degli Studi di Salerno durante il periodo 
                                universitario tramite l'utilizzo di 
                                un sistema basato su domande e risposte.
                            </p>
                        </div>
                    </li>
                    <li class="accordion-item" data-accordion-item>
                        <a href="#" class="accordion-title">Chi siamo?</a>
                        <div class="accordion-content" data-tab-content>
                            <p>
                                Siamo un gruppo di studenti di informatica, appassionati di questa 
                                materia, desiderosi di aiutare i futuri studenti creando un gruppo 
                                dove tutti i ragazzi potranno aiutarsi a vicenda.
                            </p>
                        </div>
                    </li>
                    <li class="accordion-item" data-accordion-item>
                        <a href="#" class="accordion-title">Chi ha Guidato il progetto?</a>
                        <div class="accordion-content" data-tab-content>
                            <p>
                                Siamo stati guidati dai nostri PM: 
                            <ol>
                                <li>Domenico Antonio Tropeano</li>
                                <li>Diego Avella</li>
                            </ol>
                            </p>
                        </div>
                    </li>
                    <li class="accordion-item" data-accordion-item>
                        <a href="#" class="accordion-title">Chi sono gli sviluppatori di Symposium?</a>
                        <div class="accordion-content" data-tab-content>
                            <p>Noi siamo:
                            <ul>
                                <li> Andrea Raiola </li>
                                <li> Salvatore Del Piano </li>
                                <li> Giuseppe Madonna </li>
                                <li> Angelo Maffettone </li>
                                <li> Przemyslaw Szopian </li>
                                <li> Giovanni De Maio </li>
                            </ul>
                            </p>
                        </div>
                    </li>
                    <li class="accordion-item" data-accordion-item>
                        <a href="#" class="accordion-title">Perchè lo facciamo?</a>
                        <div class="accordion-content" data-tab-content>
                            <p>
                                Perchè desideriamo prendere l'esame di Ingegneria del Software.
                            </p>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </jsp:body>
</sy:layout>
