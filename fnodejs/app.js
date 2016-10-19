
//********************************************************
//*                     basic import                     *
//********************************************************
var express = require('express');
var app = express();

app.set('views','public/html');
app.use(express.static('public'));

var engines = require('consolidate');
app.engine('html',engines.swig);
app.set('view engine','html');

var bodyParser = require('body-parser');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

var request = require('request');

var Logger = require('./infrustructure/log/logconfig.js');
var logger = new Logger().getLogger();

var ServerConstant = require('./commons/constant/ServerConstant.js');
var serverConstant = new ServerConstant();

var ExceptionCode = require('./commons/exception/ExceptionCode.js');
var exceptionCode = new ExceptionCode();



//********************************************************
//*                      access log                      *
//********************************************************
var myLogger = function (req, res, next) {
    logger.debug('request comes to node. path = ' + req.path + '... now = ' + new Date().toLocaleString());
    next();
};
app.use(myLogger);


//********************************************************
//*                     visitor route                    *
//********************************************************
var index = require('./modules/index.js');
app.use('/quartz',index);
var trigger = require('./modules/trigger/trigger.js');
app.use('/trigger',trigger);
var job = require('./modules/job/job.js');
app.use('/job',job);


//********************************************************
//*                 exception handler                    *
//********************************************************

/*app.use(logErrors);*/
//app.use(requestErrorHandler);

//function logErrors(err,req,res,next){
    //logger.error("this is error@");
    //logger.error(err.stack);
    //next(err);
//}
//function requestErrorHandler(err,req,res,next){
    //res.status(500);
        //res.render('unknowerror', {
                //error: err
        //});
/*}*/

//********************************************************
//*             start (default 7000 port)                *
//********************************************************
app.listen(serverConstant.getNodePort());
logger.info("****************************************************");
logger.info("* * Application started on http://localhost:" + serverConstant.getNodePort() + "/  *");
logger.info("****************************************************");
