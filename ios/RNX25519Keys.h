
#if __has_include("RCTBridgeModule.h")
#import "RCTBridgeModule.h"
#else
#import <React/RCTBridgeModule.h>
#endif

extern char *gen_key_pair(unsigned char *rnd);

@interface RNX25519Keys : NSObject <RCTBridgeModule>

@end
