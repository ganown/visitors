/// <reference path="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular.min.js" />

var myTasksApp = angular
               .module("myTasks", [])
               .controller("myController", function ($scope){
     var tasks = [
         {
            maintasks:"Learn SPA",
            subtasks: [
               {todo: "Learn HTML"},
               {todo: "Learn AngularJS"}
            ]
         },
         {
            maintasks:"Learn Tomcat Setup",
            subtasks: [
               {todo: "Install VM"},
               {todo: "Setup TomCat"},
               {todo: "Setup AngularJS"}
            ]
         }
         ];
     $scope.tasks=tasks;
});

