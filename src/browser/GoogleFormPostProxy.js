function submit(message){
    alert(message)
}

module.exports = {
  submit: submit
};

require('cordova/exec/proxy').add('GoogleFormPost', module.exports);