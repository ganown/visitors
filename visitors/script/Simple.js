/// <reference path="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular.min.js" />

var myApp = angular
               .module("myFirstApp", [])
               .controller("myController", function ($scope){
     var employee = {
        firstname:"Ganesh",
        lastname:"Sankaran",
        sex:"Male",
        countryflag:"images/india.jpg"
     };
     $scope.employee=employee;
});

