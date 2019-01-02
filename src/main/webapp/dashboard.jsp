<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="sy" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sy:layout title="Symposium-Benvenuto Amministratore">
    <jsp:body>
        <h1 class="text-center">Generazione Report Annuale</h1>
        <div class="grid-x">
            <div class="grid-container">
                <form method='get' action="" class="cell large-1">
                    <label>Scegli anno:
                        <select>
                            <option value="2018"> 2018  </option>
                            <option value="2017"> 2017 </option>
                        </select>
                        <input type="submit" class="button" value=Genera>
                    </label>
                </form>
                <dl>
                    <dt>
                        <i class="fi-torsos"></i>
                        Utenti Iscritti:
                    </dt>
                    <dd>un numero</dd>
                    <dt><i class="fi-prohibited"></i>
                        Utenti Bannati</dt>
                    <dd>un numero</dd>
                    <dt>
                        <i class="fi-pricetag-multiple"></i>
                        Tag più usati:
                    </dt>
                    <dd>Lista Tag</dd>
                    <dt>
                        <i class="fi-alert"></i>
                        Numero Segnalazioni</dt>
                    <dd>Un numero</dd>
                </dl>
            </div>
        </div>
    </jsp:body>
</sy:layout>