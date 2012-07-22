require 'test_helper'

class PhotosTest < ActionDispatch::IntegrationTest
  fixtures :all
  test "login and browse site" do
    # login via https
    https!
    get "/photos"
    get "/photos/new"
    get "/photo1s"
    get "/photo1s/new"
    assert_response :success
  end
end
