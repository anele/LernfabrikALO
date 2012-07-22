require 'test_helper'

class Photo1sControllerTest < ActionController::TestCase
  setup do
    @photo1 = photo1s(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:photo1s)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create photo1" do
    assert_difference('Photo1.count') do
      post :create, photo1: { :image_description => "acht", :image_name => "acht_1.png", :image_type => "1" }
    end

    assert_redirected_to photo1_path(assigns(:photo1))
  end

  test "should show photo1" do
    get :show, id: @photo1
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @photo1
    assert_response :success
  end

  test "should update photo1" do
    put :update, id: @photo1, photo1: { :image_description => "nein", :image_name => "nein_1.png", :image_type => "1" }
    assert_redirected_to photo1_path(assigns(:photo1))
  end

  test "should destroy photo1" do
    assert_difference('Photo1.count', -1) do
      delete :destroy, id: @photo1
    end

    assert_redirected_to photo1s_path
  end
end
