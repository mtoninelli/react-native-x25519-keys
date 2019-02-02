
Pod::Spec.new do |s|
  s.name         = "RNX25519Keys"
  s.version      = "1.0.0"
  s.summary      = "RNX25519Keys"
  s.description  = <<-DESC
                  RNX25519Keys
                   DESC
  s.homepage     = ""
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/author/RNX25519Keys.git", :tag => "master" }
  s.source_files  = "*.{h,m,c}", "../x25519c/*.{h,c}"
  s.private_header_files = "*.h", "../x25519c/*.h"
  s.requires_arc = true


  s.dependency "React"
  #s.dependency "others"

end

