ENV["RAILS_ENV"] = "test"
require File.expand_path('../../config/environment', __FILE__)
require 'rails/test_help'

class ActiveSupport::TestCase
  # Setup all fixtures in test/fixtures/*.(yml|csv) for all tests in alphabetical order.
  #
  # Note: You'll currently still have to declare fixtures explicitly in integration tests
  # -- they do not yet inherit this setting
  fixtures :all

  # Add more helper methods to be used by all tests here...
  
  def valid_photo_attribute(add_attributes={})
    {
      :image_name => "S_1.png",
      :image_description => "S",
      :image_type => 1
    }.merge(add_attributes)
  end
  
  def valid_number_attribute(add_attributes={})
    {
      :image_name => "sieben_1.png",
      :image_description => "sieben",
      :image_type => 1
    }.merge(add_attributes)
  end
end
