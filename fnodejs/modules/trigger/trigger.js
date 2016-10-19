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

    var url = serverConstant.getBackendUrlPrefix() + "/triggers/";
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

        //时间戳转换，便于前端展示
        for(var i = 0; i < returnData.data.length; ++i){

            if(returnData.data[i].prevFireTime == -1){
                returnData.data[i].prevFireTime = "暂无";
            } else {
                var datePrev = new Date(returnData.data[i].prevFireTime);
                returnData.data[i].prevFireTime = datePrev.getFullYear() + "年" + datePrev.getMonth() + "月" + datePrev.getDate() + "日" +
                    datePrev.getHours() + "时" + datePrev.getMinutes() + "分" + datePrev.getSeconds() + "秒";
            }

            if(returnData.data[i].nextFireTime == -1){
                returnData.data[i].nextFireTime = "暂无";
            } else {
                var dateNext = new Date(returnData.data[i].nextFireTime);
                returnData.data[i].nextFireTime = dateNext.getFullYear() + "年" + dateNext.getMonth() + "月" + dateNext.getDate() + "日" +
                    dateNext.getHours() + "时" + dateNext.getMinutes() + "分" + dateNext.getSeconds() + "秒";
            }

        }

        res.render('trigger/index',{'data':returnData.data});
    });
});

router.get('/:triggerName',function(req,res,next){
    var triggerName = req.params.triggerName;

    logger.debug("triggerName = " + triggerName);

    if(triggerName == null || triggerName == ""){
        res.render('error/unknowerror');
        return ;
    }

    var url = serverConstant.getBackendUrlPrefix() + "/trigger/" + triggerName;
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

        var trigger = returnData.data;

        //时间戳转换，便于前端展示
        if(trigger.prevFireTime == -1){
            trigger.prevFireTime = "暂无";
        } else {
            var datePrev = new Date(trigger.prevFireTime);
            trigger.prevFireTime = datePrev.getFullYear() + "年" + datePrev.getMonth() + "月" + datePrev.getDate() + "日" +
                datePrev.getHours() + "时" + datePrev.getMinutes() + "分" + datePrev.getSeconds() + "秒";
        }

        if(trigger.nextFireTime == -1){
            trigger.nextFireTime = "暂无";
        } else {
            var dateNext = new Date(trigger.nextFireTime);
            trigger.nextFireTime = dateNext.getFullYear() + "年" + dateNext.getMonth() + "月" + dateNext.getDate() + "日" +
                dateNext.getHours() + "时" + dateNext.getMinutes() + "分" + dateNext.getSeconds() + "秒";
        }

        res.json(trigger).end();
    });
})

module.exports = router;
