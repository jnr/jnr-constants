require 'gen/const_generator'
class ConstGenerator
  def initialize(name = nil, options = {}, &block)
    @constants = nil
    @const_names = []
    @includes = []
    @name = name
    @options = options
    @unknown_range = {}
    yield self if block_given?
  end
  def names
    @const_names
  end
  def const(name)
    if name.kind_of?(Array)
      @const_names.concat(name)
    else
      @const_names << name
    end
  end
  def strfunc(name)
    @options[:to_str] = name
  end
  def strfunc=(name)
    @options[:to_str] = name
  end
  def unknown_range=(range)
    @unknown_range = { :first => range[0], :last => range[1] }
  end
  def unknown_range
    @unknown_range
  end
  def include(header)
    if header.kind_of?(Array)
      @includes.concat(header)
    else
      @includes << header
    end
    
  end
  def constants
    @constants = generate unless @constants
    @constants
  end
  def generate
    gen = Constantine::ConstGenerator.new @name, @options do |cg|
      @includes.each { |header| cg.include header }
      @const_names.each { |c| cg.const c }
    end
    @constants = gen.constants
  end
end
