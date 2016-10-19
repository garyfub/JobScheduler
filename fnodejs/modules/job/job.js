var express = require('express');
var router = express.Router();
var request = require('request');

var async = require('async');
var md = require('node-markdown').Markdown;

var ServerConstant = require('../../commons/constant/ServerConstant.js');
var serverConstant = new ServerConstant();

var Logger = require('../../infrustructure/log/logconfig.js');
var logger = new Logger().getLogger();

var ExceptionCode = require('../../commons/exception/ExceptionCode.js');
var exceptionCode = new ExceptionCode();

router.get('/index',function(req,res,next){

    var url = serverConstant.getBackendUrlPrefix() + "/jobs/";
    request(url,function(error,response,body){

        if(error != null){
            logger.error(error);
            res.render('error/unknowerror');
            return ;
        }

        var returnData = JSON.parse(body);

        if(returnData.statusCode != 0){
            logger.error("url = " + url + " -- returnData.statusCode = " + returnData.statusCode);
            res.render('error/unknowerror');
            return ;
        }

        res.render('job/index',{'data':returnData.data});
    });
});

router.get('/:jobName',function(req,res,next){
    var jobName = req.params.jobName;

    logger.debug("jobName = " + jobName);

    if(jobName == null || jobName == ""){
        res.render('error/unknowerror');
        return ;
    }

    var url = serverConstant.getBackendUrlPrefix() + "/job/" + jobName;
    request(url,function(error,response,body){

        if(error != null){
            logger.error(error);
            res.render('error/unknowerror');
            return ;
        }

        var returnData = JSON.parse(body);

        if(returnData.statusCode != 0){
            logger.error("url = " + url + " -- returnData.statusCode = " + returnData.statusCode);
            res.render('error/unknowerror');
            return ;
        }

        res.json(returnData.data).end();
    });
})

module.exports = router;
