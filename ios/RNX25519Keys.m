
#import "RNX25519Keys.h"

#define KEY_SIZE 32

@implementation RNX25519Keys

- (dispatch_queue_t)methodQueue
{
	return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(GenKeyPair:(RCTPromiseResolveBlock)resolve
	rejecter:(RCTPromiseRejectBlock)reject)
{
	NSMutableData *random = [NSMutableData dataWithLength:KEY_SIZE];
	int result = SecRandomCopyBytes(kSecRandomDefault, KEY_SIZE, [random mutableBytes]);
	if (result == errSecSuccess) {
		char *resp = gen_key_pair((unsigned char *)[random bytes]);
		NSString *str = [NSString stringWithCString:resp encoding:NSUTF8StringEncoding];
		free(resp);
		resolve(str);
	} else {
		NSError *error = [NSError errorWithDomain:@"RNX25519Keys" code:result userInfo: nil];
		reject(@"keypair_error", @"Can't create key pair", error);
	}
}

@end
