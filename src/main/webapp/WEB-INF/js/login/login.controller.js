(function() {
    routerApp.controller('LoginController',  ['$http', function($http) {


        this.user = {};

        this.reg = function(){
        alert(this.user.name);
        $http({
          method: 'POST',
          url: '/account/reg',
          data    : JSON.stringify(this.user)

        }).then(function successCallback(response) {
            //alert(this.user)
          }, function errorCallback(response) {
             //alert(this.user)
          });
        }
    }]);

})();