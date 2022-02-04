//package com.cat.cat.Services;
//
//
//import com.cat.cat.Model.NotificationData;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class PushNotificationService {
//
////    private Logger logger = LoggerFactory.getLogger(PushNotificationService.class);
//
//    private FCMService fcmService;
//
//    public PushNotificationService(FCMService fcmService) {
//        this.fcmService = fcmService;
//    }
//
//
//    public void sendPushNotificationToToken(NotificationData request) {
//        try {
//            fcmService.sendMessageToToken(request);
//        } catch (Exception e) {
////            logger.error(e.getMessage());
//        }
//    }
//}
