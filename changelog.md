## 2.1.0 - 2026-03-02
* feat: add startIcon property to CtaComponent
* Add optional startIcon field to the CtaComponent class to support displaying icons on buttons. This backward-compatible enhancement allows specifying an icon identifier that will be displayed on the button.
* Key changes:
* Add startIcon field as Optional<String> to CtaComponent
* Update constructor, builder methods, equals(), and hashCode() to include startIcon
* Add getter method with proper documentation
* Add builder methods for both Optional<String> and String variants
* 🌿 Generated with Fern

## 2.0.1 - 2026-02-27
* chore: update Fern CLI version to 3.93.2
* Updated the Fern CLI version from 3.79.2 to 3.93.2 in the project metadata. This update brings the latest improvements and bug fixes from the Fern CLI toolchain to the project build process.
* Key changes:
* Update cliVersion from 3.79.2 to 3.93.2 in .fern/metadata.json
* Maintain existing generator configuration and version
* Keep publish-to-central configuration unchanged
* 🌿 Generated with Fern

## 2.0.0 - 2026-02-27
* Initial release of the Java SDK.
* Provides core client functionality, authentication support, and documented usage examples to help you get started quickly.
