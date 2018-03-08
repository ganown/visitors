/// <reference path="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular.min.js" />

var myTasksApp = angular
               .module("myTechnology", [])
               .controller("myController", function ($scope){
     var technologies = [
         {language:"C#", likes:0, dislikes:0},
         {language:"Java", likes:0, dislikes:0},
         {language:"Splunk", likes:0, dislikes:0},
         {language:"Scala", likes:0, dislikes:0}
     ];
     $scope.technologies=technologies;

     $scope.incrementLikes = function (technology) {
        technology.likes++;
     }

     $scope.incrementDisLikes = function (technology) {
        technology.dislikes++;
     }
});
