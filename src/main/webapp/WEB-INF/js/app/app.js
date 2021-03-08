var routerApp = angular.module('myApp', ['ui.router']);

routerApp.config(function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/home');

     $stateProvider

         // HOME STATES AND NESTED VIEWS ========================================
         .state('home', {
             url: '/home',
             templateUrl: '/resources/js/app/partial-home.html'
         })

         .state('login', {
                      url: '/login',
                      templateUrl: '/resources/js/login/login.main.template.html',
                      controller: 'LoginController',
                      controllerAs: 'loginCtrl'
                  })
                  .state('login.reg', {
                                        url: '/registration',
                                        templateUrl: '/resources/js/login/registration.main.template.html',
                                        controller: 'LoginController',
                                        controllerAs: 'loginCtrl'
                                    })

         // nested list with custom controller
         .state('home.list', {
             url: '/list',
             templateUrl: '/resources/js/app/partial-home-list.html',
             controller: function($scope) {
                 $scope.dogs = ['Bernese', 'Husky', 'Goldendoodle'];
             }
         })

          .state('about', {
                 url: '/about',
                 views: {

                     // the main template will be placed here (relatively named)
                     '': { templateUrl: '/resources/js/app/partial-about.html' },

                     // the child views will be defined here (absolutely named)
                     'columnOne@about': { template: 'Look I am a column!' },

                     // for column two, we'll define a separate controller
                     'columnTwo@about': {
                         templateUrl: '/resources/js/app/table-data.html',
                         controller: 'scotchController'
                     }
                 }

             })

         // nested list with just some random string data
         .state('home.paragraph', {
             url: '/paragraph',
             template: 'I could sure use a drink right now.'
         })


});

routerApp.controller('scotchController', function($scope) {

    $scope.message = 'test';

    $scope.scotches = [
        {
            name: 'Macallan 12',
            price: 50
        },
        {
            name: 'Chivas Regal Royal Salute',
            price: 10000
        },
        {
            name: 'Glenfiddich 1937',
            price: 20000
        }
    ];

});

routerApp.controller('AbcController', ['$scope', '$state', function($scope, $state) {
   $scope.$state = $state;
}]);