// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from proj.djinni

#import "ezored/util/EZRLoggerLevel.h"
#import <Foundation/Foundation.h>
@class EZRLogger;
@protocol EZRLoggerPlatformService;


@interface EZRLogger : NSObject

+ (nullable EZRLogger *)shared;

- (void)setPlatformService:(nullable id<EZRLoggerPlatformService>)ps;

- (nullable id<EZRLoggerPlatformService>)getPlatformService;

- (BOOL)hasPlatformService;

- (BOOL)allowedLevel:(EZRLoggerLevel)level;

- (void)setLevel:(EZRLoggerLevel)level;

+ (void)v:(nonnull NSString *)message;

+ (void)d:(nonnull NSString *)message;

+ (void)i:(nonnull NSString *)message;

+ (void)w:(nonnull NSString *)message;

+ (void)e:(nonnull NSString *)message;

+ (void)f:(nonnull NSString *)message;

+ (void)setGroup:(nonnull NSString *)group;

@end